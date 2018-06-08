package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes3.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long enx = 0L;
    private static final Long eny = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity env;
    private a enw;
    private String imageUrl;
    private final long mGroupId;

    public static void aJy() {
        enx = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.enw = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.yC().yD();
        this.env = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String bg(int i, int i2) {
        if (System.currentTimeMillis() - enx.longValue() > eny.longValue()) {
            enx = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + enx;
    }

    public void saveImage() {
        this.enw = new a();
        this.enw.execute(new String[0]);
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
                    return GroupCardModel.this.env.getPageContext().getString(d.k.save_fail);
                }
                String eL = ar.eL(this.mUrl);
                if (eL == null) {
                    return GroupCardModel.this.env.getPageContext().getString(d.k.save_fail);
                }
                String str = eL + ".jpg";
                for (int i = 0; l.dS(str) && i < 10000; i++) {
                    str = eL + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mUrl + "&t=" + GroupCardModel.enx, 10, new Object[0]);
                if (aVar != null && (mZ = aVar.mZ()) != null) {
                    String a = l.a((String) null, str, mZ, 80);
                    if (a != null) {
                        new x(GroupCardModel.this.env.getPageContext().getPageActivity()).ex(a);
                        return GroupCardModel.this.env.getPageContext().getString(d.k.save_image_to_album);
                    }
                    return l.yc();
                }
                return GroupCardModel.this.env.getPageContext().getString(d.k.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.env.getPageContext().getString(d.k.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.env.showToast(str);
            GroupCardModel.this.enw = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.enw = null;
            super.cancel(true);
        }
    }
}
