package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.e;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes3.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long eVh = 0L;
    private static final Long eVi = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity eVf;
    private a eVg;
    private String imageUrl;
    private final long mGroupId;

    public static void aSJ() {
        eVh = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.eVg = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.Dc().Dd();
        this.eVf = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String bp(int i, int i2) {
        if (System.currentTimeMillis() - eVh.longValue() > eVi.longValue()) {
            eVh = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + eVh;
    }

    public void saveImage() {
        this.eVg = new a();
        this.eVg.execute(new String[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;

        public a() {
            this.mUrl = null;
            this.mUrl = GroupCardModel.this.imageUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            Bitmap op;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.eVf.getPageContext().getString(e.j.save_fail);
                }
                String fL = ar.fL(this.mUrl);
                if (fL == null) {
                    return GroupCardModel.this.eVf.getPageContext().getString(e.j.save_fail);
                }
                String str = fL + ".jpg";
                for (int i = 0; l.eS(str) && i < 10000; i++) {
                    str = fL + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jA().a(this.mUrl + "&t=" + GroupCardModel.eVh, 10, new Object[0]);
                if (aVar != null && (op = aVar.op()) != null) {
                    String a = l.a((String) null, str, op, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.eVf.getPageContext().getPageActivity()).fx(a);
                        return GroupCardModel.this.eVf.getPageContext().getString(e.j.save_image_to_album);
                    }
                    return l.CH();
                }
                return GroupCardModel.this.eVf.getPageContext().getString(e.j.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.eVf.getPageContext().getString(e.j.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.eVf.showToast(str);
            GroupCardModel.this.eVg = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.eVg = null;
            super.cancel(true);
        }
    }
}
