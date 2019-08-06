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
    private int Nk;
    HeadImageView gDH;
    ImageView gDI;
    TextView gDJ;
    private com.baidu.adp.widget.ImageView.a gDK = null;
    private a gDL = null;
    CreateGroupStepActivity gDh;
    private int gDl;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gDh = null;
        this.mView = null;
        this.gDH = null;
        this.gDI = null;
        this.gDJ = null;
        this.gDh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.gDI = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.gDH = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.gDJ = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.Nk = i2;
        this.gDl = i3;
    }

    public void bBI() {
        if (this.gDL != null) {
            this.gDL.cancel();
        }
        this.gDK = null;
        this.gDL = new a();
        this.gDL.execute(new Object[0]);
    }

    public ImageView bBJ() {
        return this.gDI;
    }

    public TextView bBK() {
        return this.gDJ;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBs() {
        this.gDI.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBt() {
        this.gDh.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gDh.getLayoutMode().onModeChanged(this.mView);
        this.gDH.refresh();
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
                i.this.gDH.setVisibility(0);
                i.this.gDK = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.gDK.a(i.this.gDH);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gDh.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.Nk));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bBv() {
        if (this.mIndex != this.gDl) {
            return this.gDh.getPageContext().getString(R.string.next_step);
        }
        return this.gDh.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBw() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bBm() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBx() {
        return true;
    }
}
