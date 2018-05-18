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
    private int FJ;
    HeadImageView dVJ;
    ImageView dVK;
    TextView dVL;
    private com.baidu.adp.widget.ImageView.a dVM = null;
    private a dVN = null;
    CreateGroupStepActivity dVj;
    private int dVn;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dVj = null;
        this.mView = null;
        this.dVJ = null;
        this.dVK = null;
        this.dVL = null;
        this.dVj = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step3_view, (ViewGroup) null);
        this.dVK = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.dVJ = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.dVL = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.FJ = i2;
        this.dVn = i3;
    }

    public void aBR() {
        if (this.dVN != null) {
            this.dVN.cancel();
        }
        this.dVM = null;
        this.dVN = new a();
        this.dVN.execute(new Object[0]);
    }

    public ImageView aBS() {
        return this.dVK;
    }

    public TextView aBT() {
        return this.dVL;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBC() {
        this.dVK.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBD() {
        this.dVj.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dVj.getLayoutMode().u(this.mView);
        this.dVJ.refresh();
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
                i.this.dVJ.setVisibility(0);
                i.this.dVM = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.dVM.a(i.this.dVJ);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dVj.getPageContext().getString(d.k.group_create_step_photo), Integer.valueOf(this.FJ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBF() {
        if (this.mIndex != this.dVn) {
            return this.dVj.getPageContext().getString(d.k.next_step);
        }
        return this.dVj.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBG() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBw() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBH() {
        return true;
    }
}
