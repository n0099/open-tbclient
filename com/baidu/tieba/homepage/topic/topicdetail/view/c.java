package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends m {
    private EditText fDZ;

    public c(Context context) {
        super(context, (String) null, 29);
        this.fCj = false;
        this.fCi = 3;
        this.fBo = new TopicDetaiInputContainer(context);
        this.fDZ = ((TopicDetaiInputContainer) this.fBo).getInputView();
        ((TopicDetaiInputContainer) this.fBo).setHint(context.getString(R.string.say_your_point));
        this.fCk = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.fDZ;
    }
}
