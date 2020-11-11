package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long kij = 0L;
    private static final Long kik = 300000L;
    private String imageUrl;
    private final GroupCardActivity kih;
    private a kii;
    private final long mGroupId;

    public static void cSU() {
        kij = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.kii = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.bqK().getEquipmentWidth();
        this.kih = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String cS(int i, int i2) {
        if (System.currentTimeMillis() - kij.longValue() > kik.longValue()) {
            kij = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + kij;
    }

    public void saveImage() {
        this.kii = new a();
        this.kii.execute(new String[0]);
    }

    /* loaded from: classes23.dex */
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
                    return GroupCardModel.this.kih.getPageContext().getString(R.string.save_fail);
                }
                String nameMd5FromUrl = av.getNameMd5FromUrl(this.mUrl);
                if (nameMd5FromUrl == null) {
                    return GroupCardModel.this.kih.getPageContext().getString(R.string.save_fail);
                }
                String str = nameMd5FromUrl + ".jpg";
                for (int i = 0; n.CheckFile(str) && i < 10000; i++) {
                    str = nameMd5FromUrl + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mS().loadResourceFromMemery(this.mUrl + "&t=" + GroupCardModel.kij, 10, new Object[0]);
                if (aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
                    String a2 = n.a(null, str, rawBitmap, 80);
                    if (a2 != null) {
                        new z(GroupCardModel.this.kih.getPageContext().getPageActivity()).saveImage(a2);
                        return GroupCardModel.this.kih.getPageContext().getString(R.string.save_image_to_album);
                    }
                    return n.getSdErrorString();
                }
                return GroupCardModel.this.kih.getPageContext().getString(R.string.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.kih.getPageContext().getString(R.string.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.kih.showToast(str);
            GroupCardModel.this.kii = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.kii = null;
            super.cancel(true);
        }
    }
}
