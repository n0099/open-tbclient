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
    CreateGroupStepActivity gCY;
    TextView gDA;
    private com.baidu.adp.widget.ImageView.a gDB = null;
    private a gDC = null;
    private int gDc;
    HeadImageView gDy;
    ImageView gDz;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCY = null;
        this.mView = null;
        this.gDy = null;
        this.gDz = null;
        this.gDA = null;
        this.gCY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.gDz = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.gDy = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.gDA = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.gDc = i3;
    }

    public void bzh() {
        if (this.gDC != null) {
            this.gDC.cancel();
        }
        this.gDB = null;
        this.gDC = new a();
        this.gDC.execute(new Object[0]);
    }

    public ImageView bzi() {
        return this.gDz;
    }

    public TextView bzj() {
        return this.gDA;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byR() {
        this.gDz.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byS() {
        this.gCY.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gCY.getLayoutMode().onModeChanged(this.mView);
        this.gDy.refresh();
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
                i.this.gDy.setVisibility(0);
                i.this.gDB = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.gDB.drawImageTo(i.this.gDy);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gCY.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byU() {
        if (this.mIndex != this.gDc) {
            return this.gCY.getPageContext().getString(R.string.next_step);
        }
        return this.gCY.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byV() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byL() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byW() {
        return true;
    }
}
