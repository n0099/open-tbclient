package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes5.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long gDe = 0L;
    private static final Long gDf = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity gDc;
    private a gDd;
    private String imageUrl;
    private final long mGroupId;

    public static void bBA() {
        gDe = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.gDd = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.ahv().ahw();
        this.gDc = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String bS(int i, int i2) {
        if (System.currentTimeMillis() - gDe.longValue() > gDf.longValue()) {
            gDe = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + gDe;
    }

    public void saveImage() {
        this.gDd = new a();
        this.gDd.execute(new String[0]);
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
            Bitmap ns;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.gDc.getPageContext().getString(R.string.save_fail);
                }
                String nT = as.nT(this.mUrl);
                if (nT == null) {
                    return GroupCardModel.this.gDc.getPageContext().getString(R.string.save_fail);
                }
                String str = nT + ".jpg";
                for (int i = 0; m.mX(str) && i < 10000; i++) {
                    str = nT + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.iv().b(this.mUrl + "&t=" + GroupCardModel.gDe, 10, new Object[0]);
                if (aVar != null && (ns = aVar.ns()) != null) {
                    String a = m.a((String) null, str, ns, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.gDc.getPageContext().getPageActivity()).nE(a);
                        return GroupCardModel.this.gDc.getPageContext().getString(R.string.save_image_to_album);
                    }
                    return m.agZ();
                }
                return GroupCardModel.this.gDc.getPageContext().getString(R.string.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.gDc.getPageContext().getString(R.string.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.gDc.showToast(str);
            GroupCardModel.this.gDd = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.gDd = null;
            super.cancel(true);
        }
    }
}
