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
    HeadImageView ihP;
    ImageView ihQ;
    TextView ihR;
    private com.baidu.adp.widget.ImageView.a ihS = null;
    private a ihT = null;
    CreateGroupStepActivity ihp;
    private int iht;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ihp = null;
        this.mView = null;
        this.ihP = null;
        this.ihQ = null;
        this.ihR = null;
        this.ihp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.ihQ = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.ihP = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.ihR = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.iht = i3;
    }

    public void ceb() {
        if (this.ihT != null) {
            this.ihT.cancel();
        }
        this.ihS = null;
        this.ihT = new a();
        this.ihT.execute(new Object[0]);
    }

    public ImageView cec() {
        return this.ihQ;
    }

    public TextView ced() {
        return this.ihR;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdL() {
        this.ihQ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdM() {
        this.ihp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ihp.getLayoutMode().onModeChanged(this.mView);
        this.ihP.refresh();
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
                i.this.ihP.setVisibility(0);
                i.this.ihS = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.ihS.drawImageTo(i.this.ihP);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ihp.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdO() {
        if (this.mIndex != this.iht) {
            return this.ihp.getPageContext().getString(R.string.next_step);
        }
        return this.ihp.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdP() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdF() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdQ() {
        return true;
    }
}
