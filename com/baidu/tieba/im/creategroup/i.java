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
public class i implements o {
    private int FN;
    HeadImageView dUF;
    ImageView dUG;
    TextView dUH;
    private com.baidu.adp.widget.ImageView.a dUI = null;
    private a dUJ = null;
    CreateGroupStepActivity dUf;
    private int dUj;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dUf = null;
        this.mView = null;
        this.dUF = null;
        this.dUG = null;
        this.dUH = null;
        this.dUf = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step3_view, (ViewGroup) null);
        this.dUG = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.dUF = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.dUH = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.FN = i2;
        this.dUj = i3;
    }

    public void aBT() {
        if (this.dUJ != null) {
            this.dUJ.cancel();
        }
        this.dUI = null;
        this.dUJ = new a();
        this.dUJ.execute(new Object[0]);
    }

    public ImageView aBU() {
        return this.dUG;
    }

    public TextView aBV() {
        return this.dUH;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBE() {
        this.dUG.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBF() {
        this.dUf.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dUf.getLayoutMode().u(this.mView);
        this.dUF.refresh();
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
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.k.Y(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.dUF.setVisibility(0);
                i.this.dUI = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.dUI.a(i.this.dUF);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dUf.getPageContext().getString(d.k.group_create_step_photo), Integer.valueOf(this.FN));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBH() {
        if (this.mIndex != this.dUj) {
            return this.dUf.getPageContext().getString(d.k.next_step);
        }
        return this.dUf.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBI() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBJ() {
        return true;
    }
}
