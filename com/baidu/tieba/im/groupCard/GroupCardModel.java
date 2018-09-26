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
    private final GroupCardActivity eCx;
    private a eCy;
    private String imageUrl;
    private final long mGroupId;
    private static Long eCz = 0L;
    private static final Long eCA = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);

    public static void aNs() {
        eCz = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.eCy = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.zK().zL();
        this.eCx = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String bl(int i, int i2) {
        if (System.currentTimeMillis() - eCz.longValue() > eCA.longValue()) {
            eCz = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + eCz;
    }

    public void saveImage() {
        this.eCy = new a();
        this.eCy.execute(new String[0]);
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
            Bitmap oh;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.eCx.getPageContext().getString(e.j.save_fail);
                }
                String fe = ar.fe(this.mUrl);
                if (fe == null) {
                    return GroupCardModel.this.eCx.getPageContext().getString(e.j.save_fail);
                }
                String str = fe + ".jpg";
                for (int i = 0; l.ek(str) && i < 10000; i++) {
                    str = fe + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jn().a(this.mUrl + "&t=" + GroupCardModel.eCz, 10, new Object[0]);
                if (aVar != null && (oh = aVar.oh()) != null) {
                    String a = l.a((String) null, str, oh, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.eCx.getPageContext().getPageActivity()).eQ(a);
                        return GroupCardModel.this.eCx.getPageContext().getString(e.j.save_image_to_album);
                    }
                    return l.zo();
                }
                return GroupCardModel.this.eCx.getPageContext().getString(e.j.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.eCx.getPageContext().getString(e.j.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.eCx.showToast(str);
            GroupCardModel.this.eCy = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.eCy = null;
            super.cancel(true);
        }
    }
}
