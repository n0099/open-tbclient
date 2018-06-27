package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes3.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long ers = 0L;
    private static final Long ert = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity erp;
    private a erq;
    private String imageUrl;
    private final long mGroupId;

    public static void aKf() {
        ers = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.erq = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.yQ().yR();
        this.erp = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String bf(int i, int i2) {
        if (System.currentTimeMillis() - ers.longValue() > ert.longValue()) {
            ers = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + ers;
    }

    public void saveImage() {
        this.erq = new a();
        this.erq.execute(new String[0]);
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
            Bitmap mZ;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.erp.getPageContext().getString(d.k.save_fail);
                }
                String eO = as.eO(this.mUrl);
                if (eO == null) {
                    return GroupCardModel.this.erp.getPageContext().getString(d.k.save_fail);
                }
                String str = eO + ".jpg";
                for (int i = 0; l.dV(str) && i < 10000; i++) {
                    str = eO + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mUrl + "&t=" + GroupCardModel.ers, 10, new Object[0]);
                if (aVar != null && (mZ = aVar.mZ()) != null) {
                    String a = l.a((String) null, str, mZ, 80);
                    if (a != null) {
                        new x(GroupCardModel.this.erp.getPageContext().getPageActivity()).eA(a);
                        return GroupCardModel.this.erp.getPageContext().getString(d.k.save_image_to_album);
                    }
                    return l.yq();
                }
                return GroupCardModel.this.erp.getPageContext().getString(d.k.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.erp.getPageContext().getString(d.k.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.erp.showToast(str);
            GroupCardModel.this.erq = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.erq = null;
            super.cancel(true);
        }
    }
}
