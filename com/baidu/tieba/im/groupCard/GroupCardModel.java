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
    private static Long eVV = 0L;
    private static final Long eVW = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity eVT;
    private a eVU;
    private String imageUrl;
    private final long mGroupId;

    public static void aTj() {
        eVV = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.eVU = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.Dp().Dq();
        this.eVT = groupCardActivity;
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
        if (System.currentTimeMillis() - eVV.longValue() > eVW.longValue()) {
            eVV = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + eVV;
    }

    public void saveImage() {
        this.eVU = new a();
        this.eVU.execute(new String[0]);
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
            Bitmap ot;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.eVT.getPageContext().getString(e.j.save_fail);
                }
                String fY = ar.fY(this.mUrl);
                if (fY == null) {
                    return GroupCardModel.this.eVT.getPageContext().getString(e.j.save_fail);
                }
                String str = fY + ".jpg";
                for (int i = 0; l.fb(str) && i < 10000; i++) {
                    str = fY + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jA().a(this.mUrl + "&t=" + GroupCardModel.eVV, 10, new Object[0]);
                if (aVar != null && (ot = aVar.ot()) != null) {
                    String a = l.a((String) null, str, ot, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.eVT.getPageContext().getPageActivity()).fK(a);
                        return GroupCardModel.this.eVT.getPageContext().getString(e.j.save_image_to_album);
                    }
                    return l.CU();
                }
                return GroupCardModel.this.eVT.getPageContext().getString(e.j.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.eVT.getPageContext().getString(e.j.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.eVT.showToast(str);
            GroupCardModel.this.eVU = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.eVU = null;
            super.cancel(true);
        }
    }
}
