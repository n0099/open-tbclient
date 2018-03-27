package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i implements p {
    private int avb;
    HeadImageView eAb;
    ImageView eAc;
    TextView eAd;
    private com.baidu.adp.widget.a.a eAe = null;
    private a eAf = null;
    CreateGroupStepActivity ezB;
    private int ezF;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezB = null;
        this.mView = null;
        this.eAb = null;
        this.eAc = null;
        this.eAd = null;
        this.ezB = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step3_view, (ViewGroup) null);
        this.eAc = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.eAb = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.eAd = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.avb = i2;
        this.ezF = i3;
    }

    public void aGT() {
        if (this.eAf != null) {
            this.eAf.cancel();
        }
        this.eAe = null;
        this.eAf = new a();
        this.eAf.execute(new Object[0]);
    }

    public ImageView aGU() {
        return this.eAc;
    }

    public TextView aGV() {
        return this.eAd;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.eAc.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGF() {
        this.ezB.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.ezB.getLayoutMode().aM(this.mView);
        this.eAb.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.k.X(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.eAb.setVisibility(0);
                i.this.eAe = new com.baidu.adp.widget.a.a(bitmap, false, (String) null);
                i.this.eAe.a(i.this.eAb);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezB.getPageContext().getString(d.j.group_create_step_photo), Integer.valueOf(this.avb));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGH() {
        if (this.mIndex != this.ezF) {
            return this.ezB.getPageContext().getString(d.j.next_step);
        }
        return this.ezB.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGJ() {
        return true;
    }
}
