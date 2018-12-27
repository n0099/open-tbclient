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
    HeadImageView eOL;
    ImageView eOM;
    TextView eON;
    private com.baidu.adp.widget.ImageView.a eOO = null;
    private a eOP = null;
    CreateGroupStepActivity eOl;
    private int eOp;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOl = null;
        this.mView = null;
        this.eOL = null;
        this.eOM = null;
        this.eON = null;
        this.eOl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step3_view, (ViewGroup) null);
        this.eOM = (ImageView) this.mView.findViewById(e.g.step3_img_bg);
        this.eOL = (HeadImageView) this.mView.findViewById(e.g.step3_img_scr);
        this.eON = (TextView) this.mView.findViewById(e.g.create_group3);
        this.mIndex = i;
        this.OH = i2;
        this.eOp = i3;
    }

    public void aPX() {
        if (this.eOP != null) {
            this.eOP.cancel();
        }
        this.eOO = null;
        this.eOP = new a();
        this.eOP.execute(new Object[0]);
    }

    public ImageView aPY() {
        return this.eOM;
    }

    public TextView aPZ() {
        return this.eON;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aPI() {
        this.eOM.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aPJ() {
        this.eOl.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eOl.getLayoutMode().onModeChanged(this.mView);
        this.eOL.refresh();
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
                i.this.eOL.setVisibility(0);
                i.this.eOO = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.eOO.a(i.this.eOL);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOl.getPageContext().getString(e.j.group_create_step_photo), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aPL() {
        if (this.mIndex != this.eOp) {
            return this.eOl.getPageContext().getString(e.j.next_step);
        }
        return this.eOl.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPM() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aPC() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPN() {
        return true;
    }
}
