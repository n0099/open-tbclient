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
    HeadImageView dUC;
    ImageView dUD;
    TextView dUE;
    private com.baidu.adp.widget.ImageView.a dUF = null;
    private a dUG = null;
    CreateGroupStepActivity dUc;
    private int dUg;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dUc = null;
        this.mView = null;
        this.dUC = null;
        this.dUD = null;
        this.dUE = null;
        this.dUc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step3_view, (ViewGroup) null);
        this.dUD = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.dUC = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.dUE = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.FN = i2;
        this.dUg = i3;
    }

    public void aBT() {
        if (this.dUG != null) {
            this.dUG.cancel();
        }
        this.dUF = null;
        this.dUG = new a();
        this.dUG.execute(new Object[0]);
    }

    public ImageView aBU() {
        return this.dUD;
    }

    public TextView aBV() {
        return this.dUE;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBE() {
        this.dUD.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBF() {
        this.dUc.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dUc.getLayoutMode().u(this.mView);
        this.dUC.refresh();
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
                i.this.dUC.setVisibility(0);
                i.this.dUF = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.dUF.a(i.this.dUC);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dUc.getPageContext().getString(d.k.group_create_step_photo), Integer.valueOf(this.FN));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBH() {
        if (this.mIndex != this.dUg) {
            return this.dUc.getPageContext().getString(d.k.next_step);
        }
        return this.dUc.getPageContext().getString(d.k.group_create_step_done_tip);
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
