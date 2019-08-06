package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes5.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long gKi = 0L;
    private static final Long gKj = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity gKg;
    private a gKh;
    private String imageUrl;
    private final long mGroupId;

    public static void bEw() {
        gKi = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.gKh = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.aiz().aiA();
        this.gKg = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String bY(int i, int i2) {
        if (System.currentTimeMillis() - gKi.longValue() > gKj.longValue()) {
            gKi = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + gKi;
    }

    public void saveImage() {
        this.gKh = new a();
        this.gKh.execute(new String[0]);
    }

    /* loaded from: classes5.dex */
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
            Bitmap nK;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.gKg.getPageContext().getString(R.string.save_fail);
                }
                String oj = at.oj(this.mUrl);
                if (oj == null) {
                    return GroupCardModel.this.gKg.getPageContext().getString(R.string.save_fail);
                }
                String str = oj + ".jpg";
                for (int i = 0; m.ni(str) && i < 10000; i++) {
                    str = oj + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.iE().b(this.mUrl + "&t=" + GroupCardModel.gKi, 10, new Object[0]);
                if (aVar != null && (nK = aVar.nK()) != null) {
                    String a = m.a((String) null, str, nK, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.gKg.getPageContext().getPageActivity()).nP(a);
                        return GroupCardModel.this.gKg.getPageContext().getString(R.string.save_image_to_album);
                    }
                    return m.aid();
                }
                return GroupCardModel.this.gKg.getPageContext().getString(R.string.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.gKg.getPageContext().getString(R.string.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.gKg.showToast(str);
            GroupCardModel.this.gKh = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.gKh = null;
            super.cancel(true);
        }
    }
}
