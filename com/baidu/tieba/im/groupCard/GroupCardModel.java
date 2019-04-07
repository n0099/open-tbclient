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
import com.baidu.tieba.d;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes5.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long glP = 0L;
    private static final Long glQ = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity glN;
    private a glO;
    private String imageUrl;
    private final long mGroupId;

    public static void btL() {
        glP = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.glO = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.acx().acy();
        this.glN = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String bL(int i, int i2) {
        if (System.currentTimeMillis() - glP.longValue() > glQ.longValue()) {
            glP = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + glP;
    }

    public void saveImage() {
        this.glO = new a();
        this.glO.execute(new String[0]);
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
            Bitmap oy;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.glN.getPageContext().getString(d.j.save_fail);
                }
                String mL = as.mL(this.mUrl);
                if (mL == null) {
                    return GroupCardModel.this.glN.getPageContext().getString(d.j.save_fail);
                }
                String str = mL + ".jpg";
                for (int i = 0; m.lP(str) && i < 10000; i++) {
                    str = mL + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jB().a(this.mUrl + "&t=" + GroupCardModel.glP, 10, new Object[0]);
                if (aVar != null && (oy = aVar.oy()) != null) {
                    String a = m.a((String) null, str, oy, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.glN.getPageContext().getPageActivity()).mw(a);
                        return GroupCardModel.this.glN.getPageContext().getString(d.j.save_image_to_album);
                    }
                    return m.acb();
                }
                return GroupCardModel.this.glN.getPageContext().getString(d.j.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.glN.getPageContext().getString(d.j.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.glN.showToast(str);
            GroupCardModel.this.glO = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.glO = null;
            super.cancel(true);
        }
    }
}
