package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.y;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String erE;
    private List<String> erF;
    private b erG;
    private boolean erH;

    /* renamed from: com.baidu.tbadk.coreExtra.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0487a {
        void bdZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private static a erL = new a();
    }

    public static a bdU() {
        return c.erL;
    }

    private a() {
        this.erE = null;
        this.erF = null;
        this.erG = null;
        this.erH = false;
        this.erH = false;
        this.erF = null;
    }

    public int bdV() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String bdW() {
        int bdV = bdV();
        if (bdV >= 10) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.aVP().putString("KeyOfSharedPrefValidIp", "");
            this.erE = null;
            return null;
        }
        if (this.erE == null) {
            this.erE = com.baidu.tbadk.core.sharedPref.b.aVP().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.erE)) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt("KeyOfSharedPrefImCount", bdV + 1);
        } else {
            this.erE = null;
        }
        return this.erE;
    }

    public void xZ(String str) {
        if (!"ws://im.tieba.baidu.com:8000".equals(str)) {
            this.erE = str;
            com.baidu.tbadk.core.sharedPref.b.aVP().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> getIpList() {
        if (this.erF == null) {
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aVP().getLong("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.erF = ya(com.baidu.tbadk.core.sharedPref.b.aVP().getString("KeyOfSharedPrefIpList", null));
        }
        return this.erF;
    }

    public void bdX() {
        this.erH = false;
    }

    public boolean bdY() {
        return this.erH;
    }

    public void a(InterfaceC0487a interfaceC0487a) {
        if (this.erG == null) {
            this.erH = true;
            this.erG = new b(interfaceC0487a);
            this.erG.setSelfExecute(true);
            this.erG.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> ya(String str) {
        String[] split;
        ArrayList arrayList = null;
        if (str != null && str.length() > 0 && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length > 0) {
            arrayList = new ArrayList(3);
            for (String str2 : split) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<Object, Integer, Void> {
        private InterfaceC0487a erI;
        private volatile y mNetwork = null;

        public b(InterfaceC0487a interfaceC0487a) {
            this.erI = null;
            this.erI = interfaceC0487a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str;
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aWu().aWW().isRequestSuccess() && postNetData != null) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        a.this.erF = a.this.ya(optString);
                        if (a.this.erF != null && a.this.erF.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < a.this.erF.size(); i++) {
                                String str2 = (String) a.this.erF.get(i);
                                f fVar = new f();
                                fVar.yd(str2);
                                if (fVar.isSucc()) {
                                    hashMap.put(str2, Integer.valueOf(fVar.beh()));
                                }
                            }
                            if (hashMap.size() > 0) {
                                a.this.erF = new ArrayList();
                                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.baidu.tbadk.coreExtra.d.a.b.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // java.util.Comparator
                                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                                        return (int) (com.baidu.adp.lib.f.b.toInt(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.f.b.toInt(String.valueOf(entry2.getValue()), 0));
                                    }
                                });
                                StringBuilder sb = new StringBuilder(50);
                                int i2 = 0;
                                for (Map.Entry entry : arrayList) {
                                    a.this.erF.add(entry.getKey());
                                    if (i2 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    i2++;
                                    sb.append((String) entry.getKey());
                                }
                                str = sb.toString();
                            } else {
                                str = optString;
                            }
                            com.baidu.tbadk.core.sharedPref.b.aVP().putLong("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                            com.baidu.tbadk.core.sharedPref.b.aVP().putString("KeyOfSharedPrefIpList", str);
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            a.this.erG = null;
            if (this.erI != null) {
                this.erI.bdZ();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled(Void r3) {
            a.this.erG = null;
            if (this.erI != null) {
                this.erI.bdZ();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.erG = null;
            if (this.erI != null) {
                this.erI.bdZ();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            a.this.erG = null;
            super.cancel(true);
        }
    }
}
