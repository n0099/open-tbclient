package com.baidu.tieba.ala.person.c;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.tieba.ala.person.c.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private InterfaceC0379a evE;
    private b evF;
    private c evG;
    private c evH;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0379a {
        void a(com.baidu.tieba.ala.person.a.d dVar);

        void b(PersonUserData personUserData);

        void b(com.baidu.tieba.ala.person.a.d dVar);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.evG = new c(tbPageContext);
        this.evH = new c(tbPageContext);
        this.evG.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.evE != null) {
                    a.this.evE.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.evH.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.evE != null) {
                    a.this.evE.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.evE != null) {
                this.evE.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.evF = new b();
        this.evF.execute(str, str2, str3, str4, str5);
        cs(str, str4);
    }

    public void cs(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.evG.setPn(-1);
            this.evG.i(0, str, str2);
            this.evH.setPn(-1);
            this.evH.i(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.evF != null && !this.evF.isCancelled()) {
            this.evF.cancel();
        }
        if (this.evE != null) {
            this.evE.onFail(null);
        }
    }

    public void a(InterfaceC0379a interfaceC0379a) {
        this.evE = interfaceC0379a;
    }

    /* loaded from: classes6.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            PersonUserData personUserData;
            JSONException e;
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "ala/user/getUserInfoSDK");
            netWork.addPostData("user_id", strArr[0]);
            netWork.addPostData("anchor_id", strArr[1]);
            netWork.addPostData("group_id", strArr[2]);
            netWork.addPostData("meta_key", strArr[3]);
            netWork.addPostData("show_name", strArr[4]);
            netWork.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            String postNetData = netWork.postNetData();
            if (netWork.isRequestSuccess()) {
                String uj = com.baidu.tieba.ala.person.d.a.uj(postNetData);
                if (TextUtils.isEmpty(uj)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(uj);
                    personUserData = new PersonUserData();
                    try {
                        personUserData.parserJson(jSONObject);
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        return personUserData;
                    }
                } catch (JSONException e3) {
                    personUserData = null;
                    e = e3;
                }
            } else {
                personUserData = null;
            }
            return personUserData;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (a.this.evE != null) {
                a.this.evE.b((PersonUserData) obj);
            }
        }
    }
}
