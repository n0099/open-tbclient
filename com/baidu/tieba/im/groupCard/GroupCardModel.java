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
    private static Long gJq = 0L;
    private static final Long gJr = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity gJo;
    private a gJp;
    private String imageUrl;
    private final long mGroupId;

    public static void bEi() {
        gJq = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.gJp = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.aix().aiy();
        this.gJo = groupCardActivity;
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
        if (System.currentTimeMillis() - gJq.longValue() > gJr.longValue()) {
            gJq = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + gJq;
    }

    public void saveImage() {
        this.gJp = new a();
        this.gJp.execute(new String[0]);
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
                    return GroupCardModel.this.gJo.getPageContext().getString(R.string.save_fail);
                }
                String oj = at.oj(this.mUrl);
                if (oj == null) {
                    return GroupCardModel.this.gJo.getPageContext().getString(R.string.save_fail);
                }
                String str = oj + ".jpg";
                for (int i = 0; m.ni(str) && i < 10000; i++) {
                    str = oj + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.iE().b(this.mUrl + "&t=" + GroupCardModel.gJq, 10, new Object[0]);
                if (aVar != null && (nK = aVar.nK()) != null) {
                    String a = m.a((String) null, str, nK, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.gJo.getPageContext().getPageActivity()).nP(a);
                        return GroupCardModel.this.gJo.getPageContext().getString(R.string.save_image_to_album);
                    }
                    return m.aib();
                }
                return GroupCardModel.this.gJo.getPageContext().getString(R.string.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.gJo.getPageContext().getString(R.string.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.gJo.showToast(str);
            GroupCardModel.this.gJp = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.gJp = null;
            super.cancel(true);
        }
    }
}
