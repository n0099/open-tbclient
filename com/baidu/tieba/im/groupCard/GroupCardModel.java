package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long hEC = 0L;
    private static final Long hED = 300000L;
    private final GroupCardActivity hEA;
    private a hEB;
    private String imageUrl;
    private final long mGroupId;

    public static void bWl() {
        hEC = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.hEB = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.aGh().getEquipmentWidth();
        this.hEA = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String cj(int i, int i2) {
        if (System.currentTimeMillis() - hEC.longValue() > hED.longValue()) {
            hEC = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + hEC;
    }

    public void saveImage() {
        this.hEB = new a();
        this.hEB.execute(new String[0]);
    }

    /* loaded from: classes10.dex */
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
            Bitmap rawBitmap;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.hEA.getPageContext().getString(R.string.save_fail);
                }
                String nameMd5FromUrl = as.getNameMd5FromUrl(this.mUrl);
                if (nameMd5FromUrl == null) {
                    return GroupCardModel.this.hEA.getPageContext().getString(R.string.save_fail);
                }
                String str = nameMd5FromUrl + ".jpg";
                for (int i = 0; m.CheckFile(str) && i < 10000; i++) {
                    str = nameMd5FromUrl + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.gr().loadResourceFromMemery(this.mUrl + "&t=" + GroupCardModel.hEC, 10, new Object[0]);
                if (aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
                    String a = m.a(null, str, rawBitmap, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.hEA.getPageContext().getPageActivity()).saveImage(a);
                        return GroupCardModel.this.hEA.getPageContext().getString(R.string.save_image_to_album);
                    }
                    return m.getSdErrorString();
                }
                return GroupCardModel.this.hEA.getPageContext().getString(R.string.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.hEA.getPageContext().getString(R.string.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.hEA.showToast(str);
            GroupCardModel.this.hEB = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.hEB = null;
            super.cancel(true);
        }
    }
}
