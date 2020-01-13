package com.baidu.tieba.ala.person.c;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.tieba.ala.person.c.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private InterfaceC0467a fpt;
    private b fpu;
    private c fpv;
    private c fpw;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0467a {
        void a(com.baidu.tieba.ala.person.a.d dVar);

        void b(PersonUserData personUserData);

        void b(com.baidu.tieba.ala.person.a.d dVar);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fpv = new c(tbPageContext);
        this.fpw = new c(tbPageContext);
        this.fpv.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fpt != null) {
                    a.this.fpt.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.fpw.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fpt != null) {
                    a.this.fpt.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.fpt != null) {
                this.fpt.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.fpu = new b();
        this.fpu.execute(str, str2, str3, str4, str5);
        cN(str, str4);
    }

    public void cN(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.fpv.setPn(-1);
            this.fpv.g(0, str, str2);
            this.fpw.setPn(-1);
            this.fpw.g(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.fpu != null && !this.fpu.isCancelled()) {
            this.fpu.cancel();
        }
        if (this.fpt != null) {
            this.fpt.onFail(null);
        }
    }

    public void a(InterfaceC0467a interfaceC0467a) {
        this.fpt = interfaceC0467a;
    }

    /* loaded from: classes2.dex */
    private class b extends BdAsyncTask<String, Void, Object> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            PersonUserData personUserData;
            JSONException e;
            JSONObject jSONObject;
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "ala/user/getUserInfoSDK");
            netWork.addPostData("user_id", strArr[0]);
            netWork.addPostData("anchor_id", strArr[1]);
            netWork.addPostData("group_id", strArr[2]);
            netWork.addPostData("meta_key", strArr[3]);
            netWork.addPostData("show_name", strArr[4]);
            netWork.addPostData(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            netWork.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            String postNetData = netWork.postNetData();
            if (netWork.isRequestSuccess()) {
                String zl = com.baidu.tieba.ala.person.d.a.zl(postNetData);
                if (TextUtils.isEmpty(zl)) {
                    return null;
                }
                try {
                    jSONObject = new JSONObject(zl);
                    personUserData = new PersonUserData();
                } catch (JSONException e2) {
                    personUserData = null;
                    e = e2;
                }
                try {
                    personUserData.parserJson(jSONObject);
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    return personUserData;
                }
            } else {
                personUserData = null;
            }
            return personUserData;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (a.this.fpt != null) {
                a.this.fpt.b((PersonUserData) obj);
            }
        }
    }
}
