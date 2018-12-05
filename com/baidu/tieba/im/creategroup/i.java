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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class i implements o {
    private int OH;
    HeadImageView eLU;
    ImageView eLV;
    TextView eLW;
    private com.baidu.adp.widget.ImageView.a eLX = null;
    private a eLY = null;
    CreateGroupStepActivity eLu;
    private int eLy;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eLu = null;
        this.mView = null;
        this.eLU = null;
        this.eLV = null;
        this.eLW = null;
        this.eLu = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step3_view, (ViewGroup) null);
        this.eLV = (ImageView) this.mView.findViewById(e.g.step3_img_bg);
        this.eLU = (HeadImageView) this.mView.findViewById(e.g.step3_img_scr);
        this.eLW = (TextView) this.mView.findViewById(e.g.create_group3);
        this.mIndex = i;
        this.OH = i2;
        this.eLy = i3;
    }

    public void aPk() {
        if (this.eLY != null) {
            this.eLY.cancel();
        }
        this.eLX = null;
        this.eLY = new a();
        this.eLY.execute(new Object[0]);
    }

    public ImageView aPl() {
        return this.eLV;
    }

    public TextView aPm() {
        return this.eLW;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOV() {
        this.eLV.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOW() {
        this.eLu.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eLu.getLayoutMode().onModeChanged(this.mView);
        this.eLU.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.l.ax(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.eLU.setVisibility(0);
                i.this.eLX = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.eLX.a(i.this.eLU);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eLu.getPageContext().getString(e.j.group_create_step_photo), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aOY() {
        if (this.mIndex != this.eLy) {
            return this.eLu.getPageContext().getString(e.j.next_step);
        }
        return this.eLu.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aOZ() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aOP() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPa() {
        return true;
    }
}
