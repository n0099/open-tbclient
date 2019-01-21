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
    private int OT;
    CreateGroupStepActivity eOY;
    TextView ePA;
    private com.baidu.adp.widget.ImageView.a ePB = null;
    private a ePC = null;
    private int ePc;
    HeadImageView ePy;
    ImageView ePz;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOY = null;
        this.mView = null;
        this.ePy = null;
        this.ePz = null;
        this.ePA = null;
        this.eOY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step3_view, (ViewGroup) null);
        this.ePz = (ImageView) this.mView.findViewById(e.g.step3_img_bg);
        this.ePy = (HeadImageView) this.mView.findViewById(e.g.step3_img_scr);
        this.ePA = (TextView) this.mView.findViewById(e.g.create_group3);
        this.mIndex = i;
        this.OT = i2;
        this.ePc = i3;
    }

    public void aQx() {
        if (this.ePC != null) {
            this.ePC.cancel();
        }
        this.ePB = null;
        this.ePC = new a();
        this.ePC.execute(new Object[0]);
    }

    public ImageView aQy() {
        return this.ePz;
    }

    public TextView aQz() {
        return this.ePA;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQi() {
        this.ePz.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQj() {
        this.eOY.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eOY.getLayoutMode().onModeChanged(this.mView);
        this.ePy.refresh();
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
            return com.baidu.tbadk.core.util.l.ay(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.ePy.setVisibility(0);
                i.this.ePB = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.ePB.a(i.this.ePy);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOY.getPageContext().getString(e.j.group_create_step_photo), Integer.valueOf(this.OT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aQl() {
        if (this.mIndex != this.ePc) {
            return this.eOY.getPageContext().getString(e.j.next_step);
        }
        return this.eOY.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQm() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aQc() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQn() {
        return true;
    }
}
