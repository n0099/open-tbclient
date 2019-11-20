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
    HeadImageView gCH;
    ImageView gCI;
    TextView gCJ;
    private com.baidu.adp.widget.ImageView.a gCK = null;
    private a gCL = null;
    CreateGroupStepActivity gCh;
    private int gCl;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCh = null;
        this.mView = null;
        this.gCH = null;
        this.gCI = null;
        this.gCJ = null;
        this.gCh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.gCI = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.gCH = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.gCJ = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.gCl = i3;
    }

    public void bzf() {
        if (this.gCL != null) {
            this.gCL.cancel();
        }
        this.gCK = null;
        this.gCL = new a();
        this.gCL.execute(new Object[0]);
    }

    public ImageView bzg() {
        return this.gCI;
    }

    public TextView bzh() {
        return this.gCJ;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byP() {
        this.gCI.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byQ() {
        this.gCh.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gCh.getLayoutMode().onModeChanged(this.mView);
        this.gCH.refresh();
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
                i.this.gCH.setVisibility(0);
                i.this.gCK = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.gCK.drawImageTo(i.this.gCH);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gCh.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byS() {
        if (this.mIndex != this.gCl) {
            return this.gCh.getPageContext().getString(R.string.next_step);
        }
        return this.gCh.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byT() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byJ() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byU() {
        return true;
    }
}
