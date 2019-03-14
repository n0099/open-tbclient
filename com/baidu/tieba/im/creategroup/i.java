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
/* loaded from: classes5.dex */
public class i implements o {
    private int Pl;
    HeadImageView gfB;
    ImageView gfC;
    TextView gfD;
    private com.baidu.adp.widget.ImageView.a gfE = null;
    private a gfF = null;
    CreateGroupStepActivity gfb;
    private int gff;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gfb = null;
        this.mView = null;
        this.gfB = null;
        this.gfC = null;
        this.gfD = null;
        this.gfb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step3_view, (ViewGroup) null);
        this.gfC = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.gfB = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.gfD = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.Pl = i2;
        this.gff = i3;
    }

    public void brc() {
        if (this.gfF != null) {
            this.gfF.cancel();
        }
        this.gfE = null;
        this.gfF = new a();
        this.gfF.execute(new Object[0]);
    }

    public ImageView brd() {
        return this.gfC;
    }

    public TextView bre() {
        return this.gfD;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqN() {
        this.gfC.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqO() {
        this.gfb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gfb.getLayoutMode().onModeChanged(this.mView);
        this.gfB.refresh();
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
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.bF(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.gfB.setVisibility(0);
                i.this.gfE = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.gfE.a(i.this.gfB);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gfb.getPageContext().getString(d.j.group_create_step_photo), Integer.valueOf(this.Pl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqQ() {
        if (this.mIndex != this.gff) {
            return this.gfb.getPageContext().getString(d.j.next_step);
        }
        return this.gfb.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqR() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqH() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqS() {
        return true;
    }
}
