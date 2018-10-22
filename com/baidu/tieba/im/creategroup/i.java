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
    HeadImageView eDM;
    ImageView eDN;
    TextView eDO;
    private com.baidu.adp.widget.ImageView.a eDP = null;
    private a eDQ = null;
    CreateGroupStepActivity eDm;
    private int eDq;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eDm = null;
        this.mView = null;
        this.eDM = null;
        this.eDN = null;
        this.eDO = null;
        this.eDm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step3_view, (ViewGroup) null);
        this.eDN = (ImageView) this.mView.findViewById(e.g.step3_img_bg);
        this.eDM = (HeadImageView) this.mView.findViewById(e.g.step3_img_scr);
        this.eDO = (TextView) this.mView.findViewById(e.g.create_group3);
        this.mIndex = i;
        this.OG = i2;
        this.eDq = i3;
    }

    public void aNV() {
        if (this.eDQ != null) {
            this.eDQ.cancel();
        }
        this.eDP = null;
        this.eDQ = new a();
        this.eDQ.execute(new Object[0]);
    }

    public ImageView aNW() {
        return this.eDN;
    }

    public TextView aNX() {
        return this.eDO;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNG() {
        this.eDN.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNH() {
        this.eDm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eDm.getLayoutMode().onModeChanged(this.mView);
        this.eDM.refresh();
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
                i.this.eDM.setVisibility(0);
                i.this.eDP = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.eDP.a(i.this.eDM);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eDm.getPageContext().getString(e.j.group_create_step_photo), Integer.valueOf(this.OG));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNJ() {
        if (this.mIndex != this.eDq) {
            return this.eDm.getPageContext().getString(e.j.next_step);
        }
        return this.eDm.getPageContext().getString(e.j.group_create_step_done_tip);
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
