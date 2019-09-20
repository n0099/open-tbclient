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
    private int Nl;
    CreateGroupStepActivity gEY;
    TextView gFA;
    private com.baidu.adp.widget.ImageView.a gFB = null;
    private a gFC = null;
    private int gFc;
    HeadImageView gFy;
    ImageView gFz;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gEY = null;
        this.mView = null;
        this.gFy = null;
        this.gFz = null;
        this.gFA = null;
        this.gEY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.gFz = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.gFy = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.gFA = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.Nl = i2;
        this.gFc = i3;
    }

    public void bCw() {
        if (this.gFC != null) {
            this.gFC.cancel();
        }
        this.gFB = null;
        this.gFC = new a();
        this.gFC.execute(new Object[0]);
    }

    public ImageView bCx() {
        return this.gFz;
    }

    public TextView bCy() {
        return this.gFA;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCg() {
        this.gFz.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCh() {
        this.gEY.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gEY.getLayoutMode().onModeChanged(this.mView);
        this.gFy.refresh();
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
                i.this.gFy.setVisibility(0);
                i.this.gFB = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.gFB.a(i.this.gFy);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gEY.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.Nl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bCj() {
        if (this.mIndex != this.gFc) {
            return this.gEY.getPageContext().getString(R.string.next_step);
        }
        return this.gEY.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCk() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bCa() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCl() {
        return true;
    }
}
