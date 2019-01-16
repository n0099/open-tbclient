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
    CreateGroupStepActivity eOX;
    private com.baidu.adp.widget.ImageView.a ePA = null;
    private a ePB = null;
    private int ePb;
    HeadImageView ePx;
    ImageView ePy;
    TextView ePz;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOX = null;
        this.mView = null;
        this.ePx = null;
        this.ePy = null;
        this.ePz = null;
        this.eOX = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step3_view, (ViewGroup) null);
        this.ePy = (ImageView) this.mView.findViewById(e.g.step3_img_bg);
        this.ePx = (HeadImageView) this.mView.findViewById(e.g.step3_img_scr);
        this.ePz = (TextView) this.mView.findViewById(e.g.create_group3);
        this.mIndex = i;
        this.OT = i2;
        this.ePb = i3;
    }

    public void aQx() {
        if (this.ePB != null) {
            this.ePB.cancel();
        }
        this.ePA = null;
        this.ePB = new a();
        this.ePB.execute(new Object[0]);
    }

    public ImageView aQy() {
        return this.ePy;
    }

    public TextView aQz() {
        return this.ePz;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQi() {
        this.ePy.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQj() {
        this.eOX.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eOX.getLayoutMode().onModeChanged(this.mView);
        this.ePx.refresh();
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
                i.this.ePx.setVisibility(0);
                i.this.ePA = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.ePA.a(i.this.ePx);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOX.getPageContext().getString(e.j.group_create_step_photo), Integer.valueOf(this.OT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aQl() {
        if (this.mIndex != this.ePb) {
            return this.eOX.getPageContext().getString(e.j.next_step);
        }
        return this.eOX.getPageContext().getString(e.j.group_create_step_done_tip);
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
