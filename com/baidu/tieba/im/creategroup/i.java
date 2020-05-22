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
    HeadImageView iwE;
    ImageView iwF;
    TextView iwG;
    private com.baidu.adp.widget.ImageView.a iwH = null;
    private a iwI = null;
    CreateGroupStepActivity iwe;
    private int iwi;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iwe = null;
        this.mView = null;
        this.iwE = null;
        this.iwF = null;
        this.iwG = null;
        this.iwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.iwF = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.iwE = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.iwG = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.iwi = i3;
    }

    public void cky() {
        if (this.iwI != null) {
            this.iwI.cancel();
        }
        this.iwH = null;
        this.iwI = new a();
        this.iwI.execute(new Object[0]);
    }

    public ImageView ckz() {
        return this.iwF;
    }

    public TextView ckA() {
        return this.iwG;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cki() {
        this.iwF.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckj() {
        this.iwe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iwe.getLayoutMode().onModeChanged(this.mView);
        this.iwE.refresh();
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
                i.this.iwE.setVisibility(0);
                i.this.iwH = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.iwH.drawImageTo(i.this.iwE);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iwe.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String ckl() {
        if (this.mIndex != this.iwi) {
            return this.iwe.getPageContext().getString(R.string.next_step);
        }
        return this.iwe.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckm() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckc() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckn() {
        return true;
    }
}
