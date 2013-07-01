package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f628a;
    private com.baidu.tieba.util.r b = null;
    private boolean c;
    private String[] d;

    public aa(LabelActivity labelActivity, boolean z, String[] strArr) {
        this.f628a = labelActivity;
        this.c = z;
        this.d = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f628a.b(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        com.baidu.tieba.model.ai aiVar;
        try {
            if (this.d == null) {
                return null;
            }
            new com.baidu.tieba.account.af(LabelActivity.f614a, String.valueOf(this.d.length)).start();
            if (!this.c) {
                aiVar = this.f628a.q;
                DatabaseService.a(aiVar.f(), 12);
                this.f628a.O = false;
                return null;
            }
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/tag/edit_tag");
            if (this.d.length != 2) {
                this.f628a.O = false;
                return null;
            }
            if (this.d[0].length() > 0) {
                this.b.a("add_tag_id_list", this.d[0]);
            }
            if (this.d[1].length() > 0) {
                this.b.a("del_tag_id_list", this.d[1]);
            }
            this.b.d(true);
            String j = this.b.j();
            if (this.b.d() && this.b.c()) {
                return j;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f628a.N = null;
        this.f628a.b(false);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.f628a.N = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
                    if (optJSONObject.optInt("errno") == 0) {
                        DatabaseService.a("", 12);
                        this.f628a.O = false;
                    } else if (optJSONObject.has("usermsg")) {
                        String optString = optJSONObject.optString("usermsg");
                        if (optString != null && optString.length() > 0) {
                            this.f628a.a(optString);
                        } else {
                            this.f628a.a(this.f628a.getString(R.string.add_tag_fail));
                        }
                    }
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                this.f628a.a(this.f628a.getString(R.string.attention_fail));
                return;
            } finally {
                this.f628a.s();
            }
        }
        if (this.b != null && this.b.g() != null) {
            this.f628a.a(this.b.g());
        }
    }
}
