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
/* loaded from: classes10.dex */
public class i implements o {
    HeadImageView hwC;
    ImageView hwD;
    TextView hwE;
    private com.baidu.adp.widget.ImageView.a hwF = null;
    private a hwG = null;
    CreateGroupStepActivity hwc;
    private int hwg;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hwc = null;
        this.mView = null;
        this.hwC = null;
        this.hwD = null;
        this.hwE = null;
        this.hwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.hwD = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.hwC = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.hwE = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.hwg = i3;
    }

    public void bTj() {
        if (this.hwG != null) {
            this.hwG.cancel();
        }
        this.hwF = null;
        this.hwG = new a();
        this.hwG.execute(new Object[0]);
    }

    public ImageView bTk() {
        return this.hwD;
    }

    public TextView bTl() {
        return this.hwE;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        this.hwD.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSU() {
        this.hwc.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hwc.getLayoutMode().onModeChanged(this.mView);
        this.hwC.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
            return com.baidu.tbadk.core.util.m.getImage(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.hwC.setVisibility(0);
                i.this.hwF = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.hwF.drawImageTo(i.this.hwC);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hwc.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSW() {
        if (this.mIndex != this.hwg) {
            return this.hwc.getPageContext().getString(R.string.next_step);
        }
        return this.hwc.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSN() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSY() {
        return true;
    }
}
