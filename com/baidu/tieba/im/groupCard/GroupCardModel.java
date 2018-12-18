package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.e;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes3.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long eSq = 0L;
    private static final Long eSr = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity eSo;
    private a eSp;
    private String imageUrl;
    private final long mGroupId;

    public static void aRV() {
        eSq = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.eSp = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.Dc().Dd();
        this.eSo = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String bo(int i, int i2) {
        if (System.currentTimeMillis() - eSq.longValue() > eSr.longValue()) {
            eSq = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + eSq;
    }

    public void saveImage() {
        this.eSp = new a();
        this.eSp.execute(new String[0]);
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
            Bitmap op;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.eSo.getPageContext().getString(e.j.save_fail);
                }
                String fK = ar.fK(this.mUrl);
                if (fK == null) {
                    return GroupCardModel.this.eSo.getPageContext().getString(e.j.save_fail);
                }
                String str = fK + ".jpg";
                for (int i = 0; l.eS(str) && i < 10000; i++) {
                    str = fK + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jA().a(this.mUrl + "&t=" + GroupCardModel.eSq, 10, new Object[0]);
                if (aVar != null && (op = aVar.op()) != null) {
                    String a = l.a((String) null, str, op, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.eSo.getPageContext().getPageActivity()).fx(a);
                        return GroupCardModel.this.eSo.getPageContext().getString(e.j.save_image_to_album);
                    }
                    return l.CH();
                }
                return GroupCardModel.this.eSo.getPageContext().getString(e.j.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.eSo.getPageContext().getString(e.j.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.eSo.showToast(str);
            GroupCardModel.this.eSp = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.eSp = null;
            super.cancel(true);
        }
    }
}
