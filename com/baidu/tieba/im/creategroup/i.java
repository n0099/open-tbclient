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
/* loaded from: classes23.dex */
public class i implements o {
    HeadImageView jUG;
    ImageView jUH;
    TextView jUI;
    private com.baidu.adp.widget.ImageView.a jUJ = null;
    private a jUK = null;
    CreateGroupStepActivity jUg;
    private int jUk;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jUg = null;
        this.mView = null;
        this.jUG = null;
        this.jUH = null;
        this.jUI = null;
        this.jUg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.jUH = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.jUG = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.jUI = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.jUk = i3;
    }

    public void cNq() {
        if (this.jUK != null) {
            this.jUK.cancel();
        }
        this.jUJ = null;
        this.jUK = new a();
        this.jUK.execute(new Object[0]);
    }

    public ImageView cNr() {
        return this.jUH;
    }

    public TextView cNs() {
        return this.jUI;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNb() {
        this.jUH.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNc() {
        this.jUg.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jUg.getLayoutMode().onModeChanged(this.mView);
        this.jUG.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
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
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.getImage(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.jUG.setVisibility(0);
                i.this.jUJ = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.jUJ.drawImageTo(i.this.jUG);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jUg.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cNe() {
        if (this.mIndex != this.jUk) {
            return this.jUg.getPageContext().getString(R.string.next_step);
        }
        return this.jUg.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNf() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cMV() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNg() {
        return true;
    }
}
