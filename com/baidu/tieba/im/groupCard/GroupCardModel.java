package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes3.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long ebc = 0L;
    private static final Long ebd = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity eba;
    private a ebb;
    private String imageUrl;
    private final long mGroupId;

    public static void aEF() {
        ebc = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.ebb = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.vc().vd();
        this.eba = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String be(int i, int i2) {
        if (System.currentTimeMillis() - ebc.longValue() > ebd.longValue()) {
            ebc = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + ebc;
    }

    public void saveImage() {
        this.ebb = new a();
        this.ebb.execute(new String[0]);
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            Bitmap km;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.eba.getPageContext().getString(d.k.save_fail);
                }
                String em = aq.em(this.mUrl);
                if (em == null) {
                    return GroupCardModel.this.eba.getPageContext().getString(d.k.save_fail);
                }
                String str = em + ".jpg";
                for (int i = 0; k.ds(str) && i < 10000; i++) {
                    str = em + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.fp().a(this.mUrl + "&t=" + GroupCardModel.ebc, 10, new Object[0]);
                if (aVar != null && (km = aVar.km()) != null) {
                    String a = k.a((String) null, str, km, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.eba.getPageContext().getPageActivity()).dX(a);
                        return GroupCardModel.this.eba.getPageContext().getString(d.k.save_image_to_album);
                    }
                    return k.uD();
                }
                return GroupCardModel.this.eba.getPageContext().getString(d.k.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.eba.getPageContext().getString(d.k.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.eba.showToast(str);
            GroupCardModel.this.ebb = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.ebb = null;
            super.cancel(true);
        }
    }
}
