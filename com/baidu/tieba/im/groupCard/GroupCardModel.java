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
import com.baidu.tieba.f;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes3.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long evg = 0L;
    private static final Long evh = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity eve;
    private a evf;
    private String imageUrl;
    private final long mGroupId;

    public static void aLd() {
        evg = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.evf = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.yF().yG();
        this.eve = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String bh(int i, int i2) {
        if (System.currentTimeMillis() - evg.longValue() > evh.longValue()) {
            evg = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + evg;
    }

    public void saveImage() {
        this.evf = new a();
        this.evf.execute(new String[0]);
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
            Bitmap nb;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.eve.getPageContext().getString(f.j.save_fail);
                }
                String eM = as.eM(this.mUrl);
                if (eM == null) {
                    return GroupCardModel.this.eve.getPageContext().getString(f.j.save_fail);
                }
                String str = eM + ".jpg";
                for (int i = 0; l.dS(str) && i < 10000; i++) {
                    str = eM + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ih().a(this.mUrl + "&t=" + GroupCardModel.evg, 10, new Object[0]);
                if (aVar != null && (nb = aVar.nb()) != null) {
                    String a = l.a((String) null, str, nb, 80);
                    if (a != null) {
                        new x(GroupCardModel.this.eve.getPageContext().getPageActivity()).ey(a);
                        return GroupCardModel.this.eve.getPageContext().getString(f.j.save_image_to_album);
                    }
                    return l.yh();
                }
                return GroupCardModel.this.eve.getPageContext().getString(f.j.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.eve.getPageContext().getString(f.j.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.eve.showToast(str);
            GroupCardModel.this.evf = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.evf = null;
            super.cancel(true);
        }
    }
}
