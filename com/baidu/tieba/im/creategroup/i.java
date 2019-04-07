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
    CreateGroupStepActivity geP;
    private int geT;
    HeadImageView gfp;
    ImageView gfq;
    TextView gfr;
    private com.baidu.adp.widget.ImageView.a gfs = null;
    private a gft = null;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.geP = null;
        this.mView = null;
        this.gfp = null;
        this.gfq = null;
        this.gfr = null;
        this.geP = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step3_view, (ViewGroup) null);
        this.gfq = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.gfp = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.gfr = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.Pl = i2;
        this.geT = i3;
    }

    public void bqZ() {
        if (this.gft != null) {
            this.gft.cancel();
        }
        this.gfs = null;
        this.gft = new a();
        this.gft.execute(new Object[0]);
    }

    public ImageView bra() {
        return this.gfq;
    }

    public TextView brb() {
        return this.gfr;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqK() {
        this.gfq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqL() {
        this.geP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.geP.getLayoutMode().onModeChanged(this.mView);
        this.gfp.refresh();
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
                i.this.gfp.setVisibility(0);
                i.this.gfs = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.gfs.a(i.this.gfp);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.geP.getPageContext().getString(d.j.group_create_step_photo), Integer.valueOf(this.Pl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqN() {
        if (this.mIndex != this.geT) {
            return this.geP.getPageContext().getString(d.j.next_step);
        }
        return this.geP.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqO() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqE() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqP() {
        return true;
    }
}
