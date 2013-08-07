package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f839a;
    private com.baidu.tieba.util.u b = null;
    private boolean c;
    private String[] d;

    public ac(LabelActivity labelActivity, boolean z, String[] strArr) {
        this.f839a = labelActivity;
        this.c = z;
        this.d = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f839a.b(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        com.baidu.tieba.model.aq aqVar;
        try {
            if (this.d == null) {
                return null;
            }
            new com.baidu.tieba.account.ag(LabelActivity.f819a, String.valueOf(this.d.length)).start();
            if (!this.c) {
                aqVar = this.f839a.q;
                DatabaseService.a(aqVar.g(), 12);
                this.f839a.O = false;
                return null;
            }
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/tag/edit_tag");
            if (this.d.length != 2) {
                this.f839a.O = false;
                return null;
            }
            if (this.d[0].length() > 0) {
                this.b.a("add_tag_id_list", this.d[0]);
            }
            if (this.d[1].length() > 0) {
                this.b.a("del_tag_id_list", this.d[1]);
            }
            this.b.e(true);
            String k = this.b.k();
            if (this.b.e() && this.b.d()) {
                return k;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.i();
        }
        this.f839a.N = null;
        this.f839a.b(false);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.f839a.N = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
                    if (optJSONObject.optInt("errno") == 0) {
                        DatabaseService.a("", 12);
                        this.f839a.O = false;
                    } else if (optJSONObject.has("usermsg")) {
                        String optString = optJSONObject.optString("usermsg");
                        if (optString != null && optString.length() > 0) {
                            this.f839a.a(optString);
                        } else {
                            this.f839a.a(this.f839a.getString(R.string.add_tag_fail));
                        }
                    }
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                this.f839a.a(this.f839a.getString(R.string.attention_fail));
                return;
            } finally {
                this.f839a.q();
            }
        }
        if (this.b != null && this.b.h() != null) {
            this.f839a.a(this.b.h());
        }
    }
}
