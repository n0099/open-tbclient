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
    private int MU;
    HeadImageView gwC;
    ImageView gwD;
    TextView gwE;
    private com.baidu.adp.widget.ImageView.a gwF = null;
    private a gwG = null;
    CreateGroupStepActivity gwc;
    private int gwg;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwc = null;
        this.mView = null;
        this.gwC = null;
        this.gwD = null;
        this.gwE = null;
        this.gwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.gwD = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.gwC = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.gwE = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.MU = i2;
        this.gwg = i3;
    }

    public void byO() {
        if (this.gwG != null) {
            this.gwG.cancel();
        }
        this.gwF = null;
        this.gwG = new a();
        this.gwG.execute(new Object[0]);
    }

    public ImageView byP() {
        return this.gwD;
    }

    public TextView byQ() {
        return this.gwE;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byz() {
        this.gwD.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        this.gwc.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gwc.getLayoutMode().onModeChanged(this.mView);
        this.gwC.refresh();
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
        /* renamed from: p */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.bP(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.gwC.setVisibility(0);
                i.this.gwF = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.gwF.a(i.this.gwC);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwc.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.MU));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byC() {
        if (this.mIndex != this.gwg) {
            return this.gwc.getPageContext().getString(R.string.next_step);
        }
        return this.gwc.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byD() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byt() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return true;
    }
}
