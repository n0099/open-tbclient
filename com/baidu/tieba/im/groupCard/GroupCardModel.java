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
/* loaded from: classes17.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long jsh = 0L;
    private static final Long jsi = 300000L;
    private String imageUrl;
    private final GroupCardActivity jsf;
    private a jsg;
    private final long mGroupId;

    public static void cFW() {
        jsh = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.jsg = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.biN().getEquipmentWidth();
        this.jsf = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String cL(int i, int i2) {
        if (System.currentTimeMillis() - jsh.longValue() > jsi.longValue()) {
            jsh = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + jsh;
    }

    public void saveImage() {
        this.jsg = new a();
        this.jsg.execute(new String[0]);
    }

    /* loaded from: classes17.dex */
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
                    return GroupCardModel.this.jsf.getPageContext().getString(R.string.save_fail);
                }
                String nameMd5FromUrl = av.getNameMd5FromUrl(this.mUrl);
                if (nameMd5FromUrl == null) {
                    return GroupCardModel.this.jsf.getPageContext().getString(R.string.save_fail);
                }
                String str = nameMd5FromUrl + ".jpg";
                for (int i = 0; n.CheckFile(str) && i < 10000; i++) {
                    str = nameMd5FromUrl + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mM().loadResourceFromMemery(this.mUrl + "&t=" + GroupCardModel.jsh, 10, new Object[0]);
                if (aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
                    String a = n.a(null, str, rawBitmap, 80);
                    if (a != null) {
                        new z(GroupCardModel.this.jsf.getPageContext().getPageActivity()).saveImage(a);
                        return GroupCardModel.this.jsf.getPageContext().getString(R.string.save_image_to_album);
                    }
                    return n.getSdErrorString();
                }
                return GroupCardModel.this.jsf.getPageContext().getString(R.string.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.jsf.getPageContext().getString(R.string.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.jsf.showToast(str);
            GroupCardModel.this.jsg = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.jsg = null;
            super.cancel(true);
        }
    }
}
