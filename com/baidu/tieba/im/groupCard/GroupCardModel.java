package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes3.dex */
public class GroupCardModel extends BdBaseModel<GroupCardActivity> {
    private static Long eGw = 0L;
    private static final Long eGx = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity eGu;
    private a eGv;
    private String imageUrl;
    private final long mGroupId;

    public static void aJI() {
        eGw = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.eGv = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.Cs().Ct();
        this.eGu = groupCardActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String cd(int i, int i2) {
        if (System.currentTimeMillis() - eGw.longValue() > eGx.longValue()) {
            eGw = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + eGw;
    }

    public void saveImage() {
        this.eGv = new a();
        this.eGv.execute(new String[0]);
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
            Bitmap sh;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.eGu.getPageContext().getString(d.j.save_fail);
                }
                String eu = ap.eu(this.mUrl);
                if (eu == null) {
                    return GroupCardModel.this.eGu.getPageContext().getString(d.j.save_fail);
                }
                String str = eu + ".jpg";
                for (int i = 0; k.dA(str) && i < 10000; i++) {
                    str = eu + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.nm().a(this.mUrl + "&t=" + GroupCardModel.eGw, 10, new Object[0]);
                if (aVar != null && (sh = aVar.sh()) != null) {
                    String a = k.a((String) null, str, sh, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.eGu.getPageContext().getPageActivity()).ef(a);
                        return GroupCardModel.this.eGu.getPageContext().getString(d.j.save_image_to_album);
                    }
                    return k.BT();
                }
                return GroupCardModel.this.eGu.getPageContext().getString(d.j.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.eGu.getPageContext().getString(d.j.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.eGu.showToast(str);
            GroupCardModel.this.eGv = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.eGv = null;
            super.cancel(true);
        }
    }
}
