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
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class i implements o {
    HeadImageView iVB;
    ImageView iVC;
    TextView iVD;
    private com.baidu.adp.widget.ImageView.a iVE = null;
    private a iVF = null;
    CreateGroupStepActivity iVb;
    private int iVf;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iVb = null;
        this.mView = null;
        this.iVB = null;
        this.iVC = null;
        this.iVD = null;
        this.iVb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.iVC = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.iVB = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.iVD = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.iVf = i3;
    }

    public void csc() {
        if (this.iVF != null) {
            this.iVF.cancel();
        }
        this.iVE = null;
        this.iVF = new a();
        this.iVF.execute(new Object[0]);
    }

    public ImageView csd() {
        return this.iVC;
    }

    public TextView cse() {
        return this.iVD;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crM() {
        this.iVC.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crN() {
        this.iVb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iVb.getLayoutMode().onModeChanged(this.mView);
        this.iVB.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
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
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.getImage(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.iVB.setVisibility(0);
                i.this.iVE = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.iVE.drawImageTo(i.this.iVB);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iVb.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String crP() {
        if (this.mIndex != this.iVf) {
            return this.iVb.getPageContext().getString(R.string.next_step);
        }
        return this.iVb.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crQ() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int crG() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crR() {
        return true;
    }
}
