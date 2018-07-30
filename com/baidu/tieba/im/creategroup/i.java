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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i implements o {
    private int LQ;
    HeadImageView eoI;
    ImageView eoJ;
    TextView eoK;
    private com.baidu.adp.widget.ImageView.a eoL = null;
    private a eoM = null;
    CreateGroupStepActivity eoi;
    private int eom;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eoi = null;
        this.mView = null;
        this.eoI = null;
        this.eoJ = null;
        this.eoK = null;
        this.eoi = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step3_view, (ViewGroup) null);
        this.eoJ = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.eoI = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.eoK = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.LQ = i2;
        this.eom = i3;
    }

    public void aIt() {
        if (this.eoM != null) {
            this.eoM.cancel();
        }
        this.eoL = null;
        this.eoM = new a();
        this.eoM.execute(new Object[0]);
    }

    public ImageView aIu() {
        return this.eoJ;
    }

    public TextView aIv() {
        return this.eoK;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIe() {
        this.eoJ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIf() {
        this.eoi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eoi.getLayoutMode().onModeChanged(this.mView);
        this.eoI.refresh();
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
        /* renamed from: n */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.l.aa(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.eoI.setVisibility(0);
                i.this.eoL = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.eoL.a(i.this.eoI);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eoi.getPageContext().getString(d.j.group_create_step_photo), Integer.valueOf(this.LQ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIh() {
        if (this.mIndex != this.eom) {
            return this.eoi.getPageContext().getString(d.j.next_step);
        }
        return this.eoi.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIi() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHY() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIj() {
        return true;
    }
}
