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
    CreateGroupStepActivity hvO;
    private int hvS;
    HeadImageView hwo;
    ImageView hwp;
    TextView hwq;
    private com.baidu.adp.widget.ImageView.a hwr = null;
    private a hws = null;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hvO = null;
        this.mView = null;
        this.hwo = null;
        this.hwp = null;
        this.hwq = null;
        this.hvO = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.hwp = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.hwo = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.hwq = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.hvS = i3;
    }

    public void bTg() {
        if (this.hws != null) {
            this.hws.cancel();
        }
        this.hwr = null;
        this.hws = new a();
        this.hws.execute(new Object[0]);
    }

    public ImageView bTh() {
        return this.hwp;
    }

    public TextView bTi() {
        return this.hwq;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSQ() {
        this.hwp.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSR() {
        this.hvO.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hvO.getLayoutMode().onModeChanged(this.mView);
        this.hwo.refresh();
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
                i.this.hwo.setVisibility(0);
                i.this.hwr = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.hwr.drawImageTo(i.this.hwo);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hvO.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bST() {
        if (this.mIndex != this.hvS) {
            return this.hvO.getPageContext().getString(R.string.next_step);
        }
        return this.hvO.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSU() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSK() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSV() {
        return true;
    }
}
