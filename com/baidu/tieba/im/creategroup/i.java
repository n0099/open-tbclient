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
    HeadImageView ihV;
    ImageView ihW;
    TextView ihX;
    private com.baidu.adp.widget.ImageView.a ihY = null;
    private a ihZ = null;
    CreateGroupStepActivity ihv;
    private int ihz;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ihv = null;
        this.mView = null;
        this.ihV = null;
        this.ihW = null;
        this.ihX = null;
        this.ihv = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.ihW = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.ihV = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.ihX = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.ihz = i3;
    }

    public void cdZ() {
        if (this.ihZ != null) {
            this.ihZ.cancel();
        }
        this.ihY = null;
        this.ihZ = new a();
        this.ihZ.execute(new Object[0]);
    }

    public ImageView cea() {
        return this.ihW;
    }

    public TextView ceb() {
        return this.ihX;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdJ() {
        this.ihW.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdK() {
        this.ihv.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ihv.getLayoutMode().onModeChanged(this.mView);
        this.ihV.refresh();
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
                i.this.ihV.setVisibility(0);
                i.this.ihY = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.ihY.drawImageTo(i.this.ihV);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ihv.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdM() {
        if (this.mIndex != this.ihz) {
            return this.ihv.getPageContext().getString(R.string.next_step);
        }
        return this.ihv.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdN() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdD() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdO() {
        return true;
    }
}
