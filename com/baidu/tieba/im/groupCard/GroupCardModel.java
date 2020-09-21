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
/* loaded from: classes22.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long jAP = 0L;
    private static final Long jAQ = 300000L;
    private String imageUrl;
    private final GroupCardActivity jAN;
    private a jAO;
    private final long mGroupId;

    public static void cJD() {
        jAP = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.jAO = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.bjI().getEquipmentWidth();
        this.jAN = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String cO(int i, int i2) {
        if (System.currentTimeMillis() - jAP.longValue() > jAQ.longValue()) {
            jAP = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + jAP;
    }

    public void saveImage() {
        this.jAO = new a();
        this.jAO.execute(new String[0]);
    }

    /* loaded from: classes22.dex */
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
                    return GroupCardModel.this.jAN.getPageContext().getString(R.string.save_fail);
                }
                String nameMd5FromUrl = av.getNameMd5FromUrl(this.mUrl);
                if (nameMd5FromUrl == null) {
                    return GroupCardModel.this.jAN.getPageContext().getString(R.string.save_fail);
                }
                String str = nameMd5FromUrl + ".jpg";
                for (int i = 0; n.CheckFile(str) && i < 10000; i++) {
                    str = nameMd5FromUrl + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mR().loadResourceFromMemery(this.mUrl + "&t=" + GroupCardModel.jAP, 10, new Object[0]);
                if (aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
                    String a = n.a(null, str, rawBitmap, 80);
                    if (a != null) {
                        new z(GroupCardModel.this.jAN.getPageContext().getPageActivity()).saveImage(a);
                        return GroupCardModel.this.jAN.getPageContext().getString(R.string.save_image_to_album);
                    }
                    return n.getSdErrorString();
                }
                return GroupCardModel.this.jAN.getPageContext().getString(R.string.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.jAN.getPageContext().getString(R.string.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.jAN.showToast(str);
            GroupCardModel.this.jAO = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.jAO = null;
            super.cancel(true);
        }
    }
}
