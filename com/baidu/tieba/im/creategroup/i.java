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
    CreateGroupStepActivity iwR;
    private int iwV;
    HeadImageView ixr;
    ImageView ixs;
    TextView ixt;
    private com.baidu.adp.widget.ImageView.a ixu = null;
    private a ixv = null;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iwR = null;
        this.mView = null;
        this.ixr = null;
        this.ixs = null;
        this.ixt = null;
        this.iwR = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.ixs = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.ixr = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.ixt = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.iwV = i3;
    }

    public void ckH() {
        if (this.ixv != null) {
            this.ixv.cancel();
        }
        this.ixu = null;
        this.ixv = new a();
        this.ixv.execute(new Object[0]);
    }

    public ImageView ckI() {
        return this.ixs;
    }

    public TextView ckJ() {
        return this.ixt;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckr() {
        this.ixs.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cks() {
        this.iwR.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iwR.getLayoutMode().onModeChanged(this.mView);
        this.ixr.refresh();
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
                i.this.ixr.setVisibility(0);
                i.this.ixu = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.ixu.drawImageTo(i.this.ixr);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iwR.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cku() {
        if (this.mIndex != this.iwV) {
            return this.iwR.getPageContext().getString(R.string.next_step);
        }
        return this.iwR.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckv() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckl() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckw() {
        return true;
    }
}
