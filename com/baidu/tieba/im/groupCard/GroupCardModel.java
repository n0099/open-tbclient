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
    private static Long eKi = 0L;
    private static final Long eKj = Long.valueOf((long) ReportUserInfoModel.TIME_INTERVAL);
    private final GroupCardActivity eKg;
    private a eKh;
    private String imageUrl;
    private final long mGroupId;

    public static void aQH() {
        eKi = 0L;
    }

    public GroupCardModel(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity.getPageContext());
        this.eKh = null;
        this.imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl += this.mGroupId;
        this.imageUrl += "&w=" + LocalViewSize.BR().BS();
        this.eKg = groupCardActivity;
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
        if (System.currentTimeMillis() - eKi.longValue() > eKj.longValue()) {
            eKi = Long.valueOf(System.currentTimeMillis());
        }
        return this.imageUrl + "&t=" + eKi;
    }

    public void saveImage() {
        this.eKh = new a();
        this.eKh.execute(new String[0]);
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
            Bitmap os;
            try {
                if (this.mUrl == null || this.mUrl.length() <= 0) {
                    return GroupCardModel.this.eKg.getPageContext().getString(e.j.save_fail);
                }
                String fs = ar.fs(this.mUrl);
                if (fs == null) {
                    return GroupCardModel.this.eKg.getPageContext().getString(e.j.save_fail);
                }
                String str = fs + ".jpg";
                for (int i = 0; l.eA(str) && i < 10000; i++) {
                    str = fs + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                }
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jC().a(this.mUrl + "&t=" + GroupCardModel.eKi, 10, new Object[0]);
                if (aVar != null && (os = aVar.os()) != null) {
                    String a = l.a((String) null, str, os, 80);
                    if (a != null) {
                        new w(GroupCardModel.this.eKg.getPageContext().getPageActivity()).ff(a);
                        return GroupCardModel.this.eKg.getPageContext().getString(e.j.save_image_to_album);
                    }
                    return l.Bw();
                }
                return GroupCardModel.this.eKg.getPageContext().getString(e.j.save_fail);
            } catch (Exception e) {
                return GroupCardModel.this.eKg.getPageContext().getString(e.j.save_fail);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            GroupCardModel.this.eKg.showToast(str);
            GroupCardModel.this.eKh = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            GroupCardModel.this.eKh = null;
            super.cancel(true);
        }
    }
}
