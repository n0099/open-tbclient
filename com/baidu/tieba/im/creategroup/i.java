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
/* loaded from: classes22.dex */
public class i implements o {
    CreateGroupStepActivity kaN;
    private int kaR;
    HeadImageView kbn;
    ImageView kbo;
    TextView kbp;
    private com.baidu.adp.widget.ImageView.a kbq = null;
    private a kbr = null;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kaN = null;
        this.mView = null;
        this.kbn = null;
        this.kbo = null;
        this.kbp = null;
        this.kaN = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.kbo = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.kbn = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.kbp = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.kaR = i3;
    }

    public void cPx() {
        if (this.kbr != null) {
            this.kbr.cancel();
        }
        this.kbq = null;
        this.kbr = new a();
        this.kbr.execute(new Object[0]);
    }

    public ImageView cPy() {
        return this.kbo;
    }

    public TextView cPz() {
        return this.kbp;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPi() {
        this.kbo.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPj() {
        this.kaN.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kaN.getLayoutMode().onModeChanged(this.mView);
        this.kbn.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
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
                i.this.kbn.setVisibility(0);
                i.this.kbq = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.kbq.drawImageTo(i.this.kbn);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kaN.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPl() {
        if (this.mIndex != this.kaR) {
            return this.kaN.getPageContext().getString(R.string.next_step);
        }
        return this.kaN.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPm() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPc() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPn() {
        return true;
    }
}
