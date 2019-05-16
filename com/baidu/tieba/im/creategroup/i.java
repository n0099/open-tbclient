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
/* loaded from: classes5.dex */
public class i implements o {
    private int MU;
    HeadImageView gwB;
    ImageView gwC;
    TextView gwD;
    private com.baidu.adp.widget.ImageView.a gwE = null;
    private a gwF = null;
    CreateGroupStepActivity gwb;
    private int gwf;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwb = null;
        this.mView = null;
        this.gwB = null;
        this.gwC = null;
        this.gwD = null;
        this.gwb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.gwC = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.gwB = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.gwD = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.MU = i2;
        this.gwf = i3;
    }

    public void byL() {
        if (this.gwF != null) {
            this.gwF.cancel();
        }
        this.gwE = null;
        this.gwF = new a();
        this.gwF.execute(new Object[0]);
    }

    public ImageView byM() {
        return this.gwC;
    }

    public TextView byN() {
        return this.gwD;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byw() {
        this.gwC.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byx() {
        this.gwb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gwb.getLayoutMode().onModeChanged(this.mView);
        this.gwB.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
        /* renamed from: p */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.bP(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.gwB.setVisibility(0);
                i.this.gwE = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.gwE.a(i.this.gwB);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwb.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.MU));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byz() {
        if (this.mIndex != this.gwf) {
            return this.gwb.getPageContext().getString(R.string.next_step);
        }
        return this.gwb.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byA() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byq() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byB() {
        return true;
    }
}
