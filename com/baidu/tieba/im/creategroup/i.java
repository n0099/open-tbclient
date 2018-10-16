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
    private int OG;
    HeadImageView eDL;
    ImageView eDM;
    TextView eDN;
    private com.baidu.adp.widget.ImageView.a eDO = null;
    private a eDP = null;
    CreateGroupStepActivity eDl;
    private int eDp;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eDl = null;
        this.mView = null;
        this.eDL = null;
        this.eDM = null;
        this.eDN = null;
        this.eDl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step3_view, (ViewGroup) null);
        this.eDM = (ImageView) this.mView.findViewById(e.g.step3_img_bg);
        this.eDL = (HeadImageView) this.mView.findViewById(e.g.step3_img_scr);
        this.eDN = (TextView) this.mView.findViewById(e.g.create_group3);
        this.mIndex = i;
        this.OG = i2;
        this.eDp = i3;
    }

    public void aNV() {
        if (this.eDP != null) {
            this.eDP.cancel();
        }
        this.eDO = null;
        this.eDP = new a();
        this.eDP.execute(new Object[0]);
    }

    public ImageView aNW() {
        return this.eDM;
    }

    public TextView aNX() {
        return this.eDN;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNG() {
        this.eDM.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNH() {
        this.eDl.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eDl.getLayoutMode().onModeChanged(this.mView);
        this.eDL.refresh();
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
            return com.baidu.tbadk.core.util.l.au(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.eDL.setVisibility(0);
                i.this.eDO = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.eDO.a(i.this.eDL);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eDl.getPageContext().getString(e.j.group_create_step_photo), Integer.valueOf(this.OG));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNJ() {
        if (this.mIndex != this.eDp) {
            return this.eDl.getPageContext().getString(e.j.next_step);
        }
        return this.eDl.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNK() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aNA() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNL() {
        return true;
    }
}
