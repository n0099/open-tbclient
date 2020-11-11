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
/* loaded from: classes23.dex */
public class i implements o {
    HeadImageView kaD;
    ImageView kaE;
    TextView kaF;
    private com.baidu.adp.widget.ImageView.a kaG = null;
    private a kaH = null;
    CreateGroupStepActivity kac;
    private int kag;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kac = null;
        this.mView = null;
        this.kaD = null;
        this.kaE = null;
        this.kaF = null;
        this.kac = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.kaE = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.kaD = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.kaF = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.kag = i3;
    }

    public void cPR() {
        if (this.kaH != null) {
            this.kaH.cancel();
        }
        this.kaG = null;
        this.kaH = new a();
        this.kaH.execute(new Object[0]);
    }

    public ImageView cPS() {
        return this.kaE;
    }

    public TextView cPT() {
        return this.kaF;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPC() {
        this.kaE.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPD() {
        this.kac.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kac.getLayoutMode().onModeChanged(this.mView);
        this.kaD.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
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
                i.this.kaD.setVisibility(0);
                i.this.kaG = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.kaG.drawImageTo(i.this.kaD);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kac.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPF() {
        if (this.mIndex != this.kag) {
            return this.kac.getPageContext().getString(R.string.next_step);
        }
        return this.kac.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPG() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPw() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPH() {
        return true;
    }
}
