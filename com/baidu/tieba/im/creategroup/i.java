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
    HeadImageView jkG;
    ImageView jkH;
    TextView jkI;
    private com.baidu.adp.widget.ImageView.a jkJ = null;
    private a jkK = null;
    CreateGroupStepActivity jkg;
    private int jkk;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jkg = null;
        this.mView = null;
        this.jkG = null;
        this.jkH = null;
        this.jkI = null;
        this.jkg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.jkH = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.jkG = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.jkI = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.jkk = i3;
    }

    public void cCU() {
        if (this.jkK != null) {
            this.jkK.cancel();
        }
        this.jkJ = null;
        this.jkK = new a();
        this.jkK.execute(new Object[0]);
    }

    public ImageView cCV() {
        return this.jkH;
    }

    public TextView cCW() {
        return this.jkI;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        this.jkH.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCG() {
        this.jkg.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jkg.getLayoutMode().onModeChanged(this.mView);
        this.jkG.refresh();
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
        /* renamed from: g */
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
                i.this.jkG.setVisibility(0);
                i.this.jkJ = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.jkJ.drawImageTo(i.this.jkG);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jkg.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCI() {
        if (this.mIndex != this.jkk) {
            return this.jkg.getPageContext().getString(R.string.next_step);
        }
        return this.jkg.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCz() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCK() {
        return true;
    }
}
