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
    private int MT;
    HeadImageView gwE;
    ImageView gwF;
    TextView gwG;
    private com.baidu.adp.widget.ImageView.a gwH = null;
    private a gwI = null;
    CreateGroupStepActivity gwe;
    private int gwi;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwe = null;
        this.mView = null;
        this.gwE = null;
        this.gwF = null;
        this.gwG = null;
        this.gwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.gwF = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.gwE = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.gwG = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.MT = i2;
        this.gwi = i3;
    }

    public void byP() {
        if (this.gwI != null) {
            this.gwI.cancel();
        }
        this.gwH = null;
        this.gwI = new a();
        this.gwI.execute(new Object[0]);
    }

    public ImageView byQ() {
        return this.gwF;
    }

    public TextView byR() {
        return this.gwG;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        this.gwF.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byB() {
        this.gwe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gwe.getLayoutMode().onModeChanged(this.mView);
        this.gwE.refresh();
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
                i.this.gwE.setVisibility(0);
                i.this.gwH = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.gwH.a(i.this.gwE);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwe.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.MT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byD() {
        if (this.mIndex != this.gwi) {
            return this.gwe.getPageContext().getString(R.string.next_step);
        }
        return this.gwe.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byu() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byF() {
        return true;
    }
}
